#Java integration for Adyen Payment System API

[Adyen](http://www.adyen.com)
> is the leading technology provider powering payments for global commerce in the 21st century.
> With a seamless solution for mobile, online and in-store transactions, our technology enables merchants to accept almost any
> type of payment, anywhere in the world.

Adyen Payment System, **APS**, lies at the heart of its payment platform and it's the service a merchant integrates with for
payment processing.

**adyen-api** aims to be a cohesive and opinionated way for consuming APS' JSON messaging based services.

##Current version and Maven dependency

```xml
    <dependency>
      <groupId>com.github.woki</groupId>
      <artifactId>payments-adyen-api</artifactId>
      <version>1.1.0</version>
    </dependency>
```
See also this [Sample Client](http://github.com/woki/adyen-client) sample built upon **ayden-api**.
It takes an authorization or modification request in YAML format and communicates with APS.

##Usage

###Client instantiation
```java
   Client client = Client
      .services(TEST_SERVICES)
      .credentials(username, password)
      .build();
```

###Authorisation
```java
   PaymentRequest request = PaymentRequestBuilder
      .merchantAccount(merchantAccount)
      .amount(new Amount(Currency.getInstance("EUR"), 1000L))
      .card(CardBuilder.number("4111111111111111").cvc("737").expiry(2016, 6).holder("Johnny Tester Visa").build())
      .reference(reference(ReferenceType.UUID))
      .shopper("willian.oki@gmail.com", "127.0.0.1", "Test/DAPI/Authorisation/Willian Oki", ShopperInteraction.Ecommerce)
      .build();
   PaymentResponse response = client.authorise(request);
```

###Capture
```java
   ModificationRequest captureRequest = ModificationRequestBuilder
      .merchantAccount(merchantAccount)
      .modificationAmount(new Amount(Currency.getInstance("EUR"), 1000L))
      .originalReference(paymentResponse.getPspReference())
      .reference(reference(ReferenceType.UUID))
      .build();
   ModificationResponse captureResponse = client.capture(captureRequest);
```

###Cancel/Refund
```java
   ModificationRequest cancelRequest = ModificationRequestBuilder
      .merchantAccount(merchantAccount)
      .originalReference(paymentResponse.getPspReference())
      .reference(reference(ReferenceType.UUID))
      .build();
   ModificationResponse cancelResponse = client.cancel(cancelRequest);
```
```java
   ModificationRequest refundRequest = ModificationRequestBuilder
      .merchantAccount(merchantAccount)
      .modificationAmount(new Amount(Currency.getInstance("EUR"), 1000L))
      .originalReference(paymentResponse.getPspReference())
      .reference(reference(ReferenceType.UUID))
      .build();
   ModificationResponse refundResponse = client.refund(refundRequest);
```
```java
   ModificationRequest cancelOrRefundRequest = ModificationRequestBuilder
       .merchantAccount(merchantAccount)
       .originalReference(paymentResponse.getPspReference())
       .reference(reference(ReferenceType.UUID))
       .build();
   ModificationResponse cancelOrRefundResponse = client.cancelOrRefund(cancelOrRefundRequest);
```
