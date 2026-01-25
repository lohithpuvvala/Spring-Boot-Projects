# Cloud Vendor API
___
## Intructions:
1. Run the Application.
2. Use 'Postman' to test the CRUD operations.
3. The API is not connected to any DB.
4. Follow this order POST -> GET -> PUT -> DELETE.
5. Can only create one instance of the Cloud Vendor Details at any point of time.

## URL:
1. ***GET*** - localhost:8080/cloudvendor/{vendorId}
2. ***POST*** - localhost:8080/cloudvendor
3. ***PUT*** - localhost:8080/cloudvendor/{vendorId}
4. ***DELETE*** - localhost:8080/cloudvendor/{vendorId}

## JSON FORMAT for POST & PUT METHODS
```json
{
    "vendorId": "C1",
    "vendorName":"Vendor 1",
    "vendorAddress": "Address 1",
    "vendorPhoneNumber": "xxxx xxxx"
}
```