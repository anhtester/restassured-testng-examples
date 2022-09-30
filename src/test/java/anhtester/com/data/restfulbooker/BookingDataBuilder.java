package anhtester.com.data.restfulbooker;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class BookingDataBuilder {

    private static final Faker FAKER = Faker.instance();

    public static BookingData getbookingData() {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        return BookingData.builder()
                .firstname(FAKER.name()
                        .firstName())
                .lastname(FAKER.name()
                        .lastName())
                .totalprice(FAKER.number()
                        .numberBetween(1, 2000))
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin(formatter.format(FAKER.date()
                                .past(20, TimeUnit.DAYS)))
                        .checkout(formatter.format(FAKER.date()
                                .future(5, TimeUnit.DAYS)))
                        .build())
                .additionalneeds("Breakfast")
                .build();

    }

    public static PartialBookingData getpartialBookingData() {
        return PartialBookingData.builder()
                .firstname(FAKER.name()
                        .firstName())
                .totalprice(FAKER.number()
                        .numberBetween(100, 5000))
                .build();
    }
}