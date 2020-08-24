/*
 * Copyright (c) 2005, tuxjsmith@gmail.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package utilities;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author john
 */
public class EncodeDecodeImage {
    
    private static String mimeString = null;
    private static BufferedImage bi = null;
    private static final String NO_IMAGE = "no image";
    
    public EncodeDecodeImage () {  
    }
    
    public static void encodeFile (String absolutePath) {

        try {
        
            bi = ImageIO.read(new File(absolutePath));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
            byte[] bytes = baos.toByteArray();

            // encode with padding
            setMimeString ( Base64.getUrlEncoder().encodeToString( bytes ) );
        } 
        catch (IOException ex) {
            
            System.err.println ( ex.getMessage() );
        }
    }
    
    public static void setMimeString (String s) {
    
        /*
         * Experimenting, attempting to reduce the size of the mime text.
         */
//        System.out.println ("s: " + s.length () );
//        
//        String foo = "";
//        
//        /*
//         * Compress the string.
//         */
//        try ( ByteArrayOutputStream out = new ByteArrayOutputStream ();
//              GZIPOutputStream gzip = new GZIPOutputStream ( out ) ) {
//            
//            gzip.write ( s.getBytes () );
//            
//            gzip.close ();
//            
//            foo = Base64.getUrlEncoder().encodeToString( out.toByteArray () );
//            
//            System.out.println ("foo: " + foo.length () );
//        }
//        catch (IOException ioe) {
//            
//            System.err.println ( ioe.getMessage () );
//        }
//        
//        try ( GZIPInputStream gis = new GZIPInputStream ( new ByteArrayInputStream ( Base64.getUrlDecoder().decode(foo) ) );
//              BufferedReader bf = new BufferedReader ( new InputStreamReader ( gis ) ) ) {
//            
//            String outStr = "",
//                   line;
//            
//            while ( ( line = bf.readLine () ) != null ) {
//                
//                outStr += line;
//            }
//            
//            System.out.println ("outStr: " + outStr.length () );
//        } catch ( IOException ioe ) {
//
//            System.err.println ( ioe.getMessage () );
//        }
        
        mimeString = s;
    }
    
    public static String getMimeString () {
        
        return (mimeString == null) ? "no image" : mimeString;
    }
    
    public static BufferedImage getBufferedImage () {
        
        return bi;
    }
    
    public static BufferedImage getBufferedImageFromBytes () {

        try {
            
            /*
             * try with resouces
             */
            try ( BufferedInputStream bin = new BufferedInputStream (new ByteArrayInputStream ( getDecodedBytes () ) ) ) {

                bi = ImageIO.read (bin);
            }
        } 
        catch (IOException ioe) {

            System.err.println (ioe.getMessage());    
        }

        return bi;
    }
    
    private static byte[] getDecodedBytes () {
        
        return Base64.getUrlDecoder().decode(EncodeDecodeImage.getMimeString());
    }
    
    public static void toImage ( String path ) {

        File file = new File( path );

        try (FileOutputStream fos = new FileOutputStream(file);) {

            fos.write (getDecodedBytes ());

        } 
        catch (Exception e) {

            System.err.println (e.getMessage ());
        }
    }
    
    public static void resetMimeString () {
        
        mimeString = NO_IMAGE;
    }
}
