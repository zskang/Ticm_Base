package com.joyin.ticm.common.util.logger.appender;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件压缩处理类.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class FileZipper extends Thread {
    /** default values for zipper - max compression */
    public static int MAX_COMPRESSION = 9;
    /** default values for zipper - no compression */
    public static int NO_COMPRESSION = 0;
    /** default values for zipper - default data block */
    public int DEFAULT_DATA_BLOCK_SIZE = 4096;

    // variables for zipper

    /** remove source file flag */
    private boolean _removeSourceFile;
    /** level of compression */
    private int _levelOfCompression;
    /** data block size */
    private int _dataBlockSize;
    /** list of files for zipping */
    private List<String> _files;
    /** file name of zipfile */
    private String _zipFileName;

    /**
     * FileZipper Constructor
     * 
     * @param zipfilename
     *            zip filename
     * @param filesToZip
     *            a list of files to be zipped
     */
    public FileZipper(String zipfilename, List<String> filesToZip) {
        _removeSourceFile = true;
        _levelOfCompression = MAX_COMPRESSION;
        _dataBlockSize = DEFAULT_DATA_BLOCK_SIZE;
        _zipFileName = zipfilename;
        _files = filesToZip;
    }

    /**
     * Return the boolean value of removeSourceFile
     * 
     * @return boolean the boolean value of removeSourceFile
     */
    public boolean isRemoveSourceFile() {
        return _removeSourceFile;
    }

    /**
     * Set the value of removeSourcefile
     * 
     * @param removeSourcefile
     *            boolean value to remove the source file after zipping
     */
    public void setRemoveSourceFile(boolean removeSourcefile) {
        _removeSourceFile = removeSourcefile;
    }

    /**
     * The main method to start this zipper thread
     */
    public void run() {
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new FileOutputStream(_zipFileName
                    + ".zip"));

            for (String file : _files) {
                File fin = new File(file);
                LogLog.info("Zipping file :" + file + " into " + _zipFileName
                        + ".zip");

                String zipFileEntry = fin.getName();

                ZipEntry ze = new ZipEntry(zipFileEntry);
                zos.setMethod(ZipOutputStream.DEFLATED);
                zos.setLevel(_levelOfCompression);
                zos.putNextEntry(ze);

                FileInputStream ins = null;
                try {
                    ins = new FileInputStream(fin);
                    int bread;
                    byte[] bin = new byte[_dataBlockSize];
                    while ((bread = ins.read(bin, 0, _dataBlockSize)) != -1) {
                        zos.write(bin, 0, bread);
                    }
                    zos.closeEntry();
                }
                catch (IOException ioe) {
                    LogLog.error("Zipping IOException: " + ioe.getMessage());
                }
                finally {
                    try {
                        if (ins != null) {
                            ins.close();
                        }
                    }
                    catch (IOException ioe) {
                        // do nothing
                    }
                }
            }
            zos.flush();

            // Delete zipped files.
            if (_removeSourceFile) {
                for (String file : _files) {
                    File delFile = new File(file);
                    delFile.delete();
                }
            }
        }
        catch (FileNotFoundException fnfe) {
            LogLog.error("FileNotFoundException: " + fnfe.getMessage());
        }
        catch (IOException ioe) {
            LogLog.error("IOException: " + ioe.getMessage());
        }
        finally {
            try {
                if (zos != null) {
                    zos.close();
                }
            }
            catch (IOException ioe) {
                // do nothing
            }
        }
    }

    // public static void main( String[] args )
    // {
    // if( args.length < 2 )
    // {
    // System.out
    // .println( "Help : java -cp classpath
    // com.sgx.clear.payment.util.log.FileZipper [zip filename] [file 1]...[file
    // n]" );
    // System.exit( 1 );
    // }
    //
    // String zipFilename = args[0];
    // List<String> files = new ArrayList<String>();
    // for ( int i = 1; i < args.length; i++ )
    // {
    // files.add( args[i] );
    // }
    //
    // FileZipper zip = new FileZipper( zipFilename, files );
    // zip.setRemoveSourceFile( false );
    // zip.start();
    //
    // }

}
