package be.cegeka.orders.supplier.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class LocalDateTimeAttributeConverterTest {

    private LocalDateTimeAttributeConverter converter = new LocalDateTimeAttributeConverter();
    private LocalDateTime localDateTime;
    private Timestamp sqlTimestamp;

    @Before
    public void setUp() throws Exception {
        localDateTime = LocalDateTime.of(2017, 12, 3, 9, 30);
        sqlTimestamp = Timestamp.valueOf(localDateTime);
    }

    @Test
    public void convertToDatabaseColumn_shouldConvertLocalDateTimeToTimeStamp() throws Exception {
        Timestamp actual = converter.convertToDatabaseColumn(localDateTime);
        Assertions.assertThat(actual).isEqualTo(sqlTimestamp);

    }

    @Test
    public void convertToEntityAttribute_shouldConvertTimestampToLocalDateTime() throws Exception {
        LocalDateTime actual = converter.convertToEntityAttribute(sqlTimestamp);
        Assertions.assertThat(actual).isEqualTo(localDateTime);
    }

    @Test
    public void convertToDatabaseColumn_ShouldNotBeEqualToNull() throws Exception {
        Timestamp actual = converter.convertToDatabaseColumn(localDateTime);
        Assertions.assertThat(actual).isNotEqualTo(null);
    }
//
//    @Test
//    public void convertNullToDatabase_ShouldBeEqualToNull() throws Exception {
//        Timestamp actual = converter.convertToDatabaseColumn(null);
//        Assertions.assertThat(actual).isEqualTo(null);
//    }

}