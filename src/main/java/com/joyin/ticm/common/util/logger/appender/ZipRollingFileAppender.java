package com.joyin.ticm.common.util.logger.appender;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Layout;
import org.apache.log4j.RollingFileAppender;

/**
 * ZipRollingFileAppender extends RollingFileAppender so that the underlying
 * file is rolled over at a user chosen file size frequency. The rolled file
 * will be zipped.
 * <p>
 * The rolling schedule is specified by the MaxFileSize option and the rolled
 * filename is determined by the DatePattern option. This pattern should follow
 * the SimpleDateFormat conventions. In particular, you must escape literal text
 * within a pair of single quotes. A formatted version of the date pattern is
 * used as the suffix for the rolled filename. If a DatePattern is not
 * specified, default pattern 'yyyyMMdd.HH.mm.ss' will be used. For more
 * information on the DatePattern, please refer to
 * {@link org.apache.log4j.DailyRollingFileAppender} and
 * {@link org.apache.log4j.RollingFileAppender}.
 * <p>
 * There is the ZipOption option and this option determine if the rolled file
 * will be zipped.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 * @see org.apache.log4j.DailyRollingFileAppender
 * @see org.apache.log4j.RollingFileAppender
 */
public class ZipRollingFileAppender extends RollingFileAppender {
    /** data pattern to append to file for rollover - default first */
    String datePattern = "yyyyMMdd.HH.mm.ss";

    /** zip option */
    String zipOption;

    /**
     * Default Constructor
     */
    public ZipRollingFileAppender() {
        super();
    }

    /**
     * Constructor with layout, filename and append
     * 
     * @param layout
     * @param filename
     * @param append
     * @throws IOException
     */
    public ZipRollingFileAppender(Layout layout, String filename, boolean append)
            throws IOException {
        super(layout, filename, append);
    }

    /**
     * Constructor with layout and filename
     * 
     * @param layout
     * @param filename
     * @throws IOException
     */
    public ZipRollingFileAppender(Layout layout, String filename)
            throws IOException {
        super(layout, filename);
    }

    /**
     * Implements the usual roll over behaviour.
     */
    public void rollOver() {
        boolean zip = zipOption != null ? new Boolean(zipOption).booleanValue()
                : false;

        // close file first
        closeFile();

        // boolean flag to determine to append to currrent log file
        boolean appendFile;

        SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
        String targetFileName = fileName + "." + formatter.format(new Date());
        File target = new File(targetFileName);

        File file = new File(fileName);
        boolean result = file.renameTo(target);
        if (result) {
            LogLog.info("[Success] Renaming file " + file + " to " + target);

            // file achieved. create new file
            appendFile = false;

            LogLog.info("To zip log file : " + zip);

            if (zip) {
                List<String> listFile = Arrays
                        .asList(new String[] { targetFileName });
                FileZipper zipper = new FileZipper(targetFileName, listFile);
                zipper.start();
            }
        }
        else {
            LogLog.warn("[Failed] Renaming file " + file + " to " + target
                    + ". Continue logging on " + file);

            // achieve file fail. continue appending to current log file
            appendFile = true;
        }

        try {
            LogLog.debug("Logging continue " + fileName);
            setFile(fileName, appendFile, bufferedIO, bufferSize);

        }
        catch (IOException e) {
            LogLog.error("setFile(" + fileName + ", false) call failed.", e);
        }
    }

    /**
     * Setter for ZipOption for Appender
     * 
     * @param inZipOption zip option
     */
    public void setZipOption(String inZipOption) {
        zipOption = inZipOption;
    }

    /**
     * Getter for ZipOption for Appender
     * 
     * @return String zip option
     */
    public String getZipOption() {
        return zipOption;
    }

    /**
     * Setter for DatePattern for Appender.
     * 
     * @param inDatePattern date pattern
     */
    public void setDatePattern(String inDatePattern) {
        try {
            // use date pattern to abstract date string and abstract the 
            // actual date object back. if both way is working the date 
            // pattern is valid.
            SimpleDateFormat sdf = new SimpleDateFormat(inDatePattern);
            sdf.setLenient(false);
            sdf.parse(sdf.format(new Date()));

            datePattern = inDatePattern;
        }
        catch (Exception e) {
            // exception = date pattern is invalid, therefore to use default
            LogLog.error("date pattern (" + inDatePattern
                    + ") invalid. use default date pattern (" + datePattern
                    + ")");
        }
    }

    /**
     * Getter for DatePattern for Appender
     * 
     * @return String date pattern
     */
    public String getDatePattern() {
        return datePattern;
    }
}
