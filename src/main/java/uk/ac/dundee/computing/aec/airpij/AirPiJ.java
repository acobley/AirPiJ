/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.airpij;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

/**
 *
 * @author Administrator
 */
public class AirPiJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            I2CBus bus = I2CFactory.getInstance(0);
            I2CDevice adxlDevice = bus.getDevice(0x53);

            adxlDevice.write(0x31, (byte) 0x0b); // Initialize
            long now = System.currentTimeMillis();
            int measurement = 0;
            adxlDevice.write(0x2D, (byte) 0x08); // Triger measuring
            while (System.currentTimeMillis() - now < 10000) {
                byte[] data = new byte[6];
                adxlDevice.read(0x32, data, 0, 6);
                int x = ((data[0] & 0x1f) << 8) + (data[1] & 0xff);
                if ((data[0] & 0x80) == 1) {
                    x = -x;
                }
                int y = ((data[0] & 0x1f) << 8) + (data[1] & 0xff);
                if ((data[0] & 0x80) == 1) {
                    y = -y;
                }
                int z = ((data[0] & 0x1f) << 8) + (data[1] & 0xff);
                if ((data[0] & 0x80) == 1) {
                    z = -z;
                }
                String sm = toString(measurement, 3);
                String sx = toString(x, 7);
                String sy = toString(y, 7);
                String sz = toString(y, 7);
                System.out.print(sm + sx + sy + sz);
                for (int i = 0; i < 24; i++) {
                    System.out.print((char) 8);
                }
                Thread.sleep(100);
                measurement++;
            }
        } catch (Exception et) {
            System.out.println("Can't get bus " + et);
        }
    }

    public static String toString(int i, int l) {
        String s = Integer.toString(i);
        return " ".substring(0, l - s.length()) + s;
    }

}
