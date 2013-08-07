package com.joyin.ticm.common.util.logger.appender;

import java.io.IOException;
import java.util.Calendar;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
/**
 * ZipDailyRollingFileAppender extends ZipRollingFileAppender so that the
 * underlying file is rolled over daily and at a user chosen file size
 * frequency. The rolled file will be zipped.
 * <p>
 * The rolling schedule is specified by the MaxFileSize option and the rolled
 * filename is determined by the DatePattern option. This pattern should follow
 * the SimpleDateFormat conventions. In particular, you must escape literal text
 * within a pair of single quotes. A formatted version of the date pattern is
 * used as the suffix for the rolled filename. If a DatePattern is not
 * specified, default pattern 'yyyyMMdd.HH.mm.ss' will be used. For more
 * information on the DatePattern, please refer to
 * {@link org.apache.log4j.DailyRollingFileAppender},
 * {@link org.apache.log4j.RollingFileAppender} and
 * {@link com.joyin.ticm.common.util.logger.appender.ZipRollingFileAppender}.
 * <p>
 * There is the ZipOption option and this option determine if the rolled file
 * will be zipped.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 * @see org.apache.log4j.DailyRollingFileAppender
 * @see org.apache.log4j.RollingFileAppender
 * @see com.joyin.ticm.common.util.logger.appender.ZipRollingFileAppender
 */
public class ZipDailyRollingFileAppender extends ZipRollingFileAppender
{
    /** instantiate 1 calendar instance for next roll */
    private Calendar _nextCalendarRoll;

    /** Constant daily increment (day) */
    private static final int DAILY_INCREMENT = 1;

    /**
     * Default Constructor
     */
    public ZipDailyRollingFileAppender()
    {
        super();
        _nextCalendarRoll = Calendar.getInstance();
    }

    /**
     * Constructor with layout, filename and append
     * 
     * @param layout
     * @param filename
     * @param append
     * @throws IOException
     */
    public ZipDailyRollingFileAppender( Layout layout, String filename,
        boolean append ) throws IOException
    {
        super( layout, filename, append );
        _nextCalendarRoll = Calendar.getInstance();
    }

    /**
     * Constructor with layout and filename
     * 
     * @param layout
     * @param filename
     * @throws IOException
     */
    public ZipDailyRollingFileAppender( Layout layout, String filename )
        throws IOException
    {
        super( layout, filename );
        _nextCalendarRoll = Calendar.getInstance();
    }

    /**
     * Compute the next calendar day roll
     * 
     * @return next calendar day roll
     */
    private Calendar _getNextCalendarDayRoll()
    {
        Calendar next = Calendar.getInstance();
        next.add( Calendar.DAY_OF_MONTH, DAILY_INCREMENT );
        next.set( Calendar.HOUR_OF_DAY, 0 );
        next.set( Calendar.MINUTE, 0 );
        next.set( Calendar.SECOND, 0 );
        next.set( Calendar.MILLISECOND, 0 );
        return next;
    }

    /**
     * Overriding subAppend of RollingFileAppender to check on daily rolling
     * criteria first
     * 
     * @see org.apache.log4j.RollingFileAppender#subAppend(org.apache.log4j.spi.LoggingEvent)
     */
    protected void subAppend( LoggingEvent event )
    {
        Calendar now = Calendar.getInstance();

        // current time more than next roll
        if( now.after( _nextCalendarRoll ) )
        {
            _nextCalendarRoll = _getNextCalendarDayRoll();
            rollOver();
        }

        // call file size appender check
        super.subAppend( event );
    }
}
