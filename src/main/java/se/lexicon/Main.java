package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.calculator.ExpressInternationalShipping;
import se.lexicon.calculator.StandardDomesticShipping;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ShippingService service = context.getBean (ShippingService.class);
        System.setProperty("spring.profiles.active","dev");
        ShippingRequest r1 = new ShippingRequest(Destination.DOMESTIC,Speed.STANDARD,5.0);
        System.out.println("Domestic Standard :" + service.quote(r1));
        ShippingRequest r2 = new ShippingRequest(Destination.INTERNATIONAL,Speed.EXPRESS, 20.0);
        System.out.println("International Express :" + service.quote(r2));
        ShippingRequest r3 = new ShippingRequest(Destination.DOMESTIC,Speed.EXPRESS, 10.0);
        System.out.println("Domestic Express:" + service.quote(r3));
        ShippingRequest r4 = new ShippingRequest (Destination.INTERNATIONAL,Speed.STANDARD,10.0 );
        System.out.println("International Standard :" + service.quote(r4));
        context.close();






                 /*
        // Manual object creation (composition root)
        List<ShippingCostCalculator> calculators = List.of(
                new StandardDomesticShipping(),
                new ExpressInternationalShipping()
        );


        ShippingCalculatorFactory factory = new ShippingCalculatorFactory(calculators);
        
        ShippingService shippingService = new ShippingService(factory);

        ShippingRequest domesticStandardRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10.0);
        System.out.println("Shipping cost: " + shippingService.quote(domesticStandardRequest));

        ShippingRequest internationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        System.out.println("Shipping cost: " + shippingService.quote(internationalExpressRequest));

        ShippingRequest lightDomesticRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 5.0);
        System.out.println("Shipping cost: " + shippingService.quote(lightDomesticRequest));

        ShippingRequest heavyInternationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        System.out.println("Shipping cost: " + shippingService.quote(heavyInternationalExpressRequest));
    }  */

    }

}
