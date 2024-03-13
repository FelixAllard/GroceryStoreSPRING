INSERT INTO clients (client_id, name, email, phone, street, city, state, postal_code, country, total_spent, number_of_points, membership_status, value, currency)
VALUES
    ('a5aded7b-71a9-45bc-b218-1b8ef7dd006c', 'Felix', 'xilef992@gmail.com', '(132) 312-1234','Hemon', 'Montreal', 'Quebec', '123asd', 'Canada', 46.42, 80, 'Active', 60.43, 'USD' ),
    ('e5c69b33-45ca-4a14-81a7-39c5f69d4f61', 'Alice', 'alice@example.com', '(555) 555-5555','123 Main St', 'Anytown', 'CA', '12345', 'USA', 100.00, 100, 'Active', 120.00, 'USD'),
    ('53ef7e64-8e4b-4e9c-8b44-2f7d8bdf5ee6', 'Bob', 'bob@example.com', '(555) 555-5555','456 Elm St', 'Othertown', 'NY', '54321', 'USA', 200.00, 150, 'Active', 180.00, 'USD'),
    ('23c11663-99b8-472b-8920-992d9f06fd55', 'Charlie', 'charlie@example.com', '(555) 555-5555','789 Oak St', 'Smalltown', 'TX', '67890', 'USA', 150.00, 120, 'Active', 140.00, 'USD'),
    ('8e8f3cbb-7c82-476e-86f0-28798bb5bb41', 'David', 'david@example.com', '(555) 555-5555','321 Pine St', 'Bigtown', 'FL', '09876', 'USA', 300.00, 200, 'Active', 220.00, 'USD'),
    ('4fb9d33b-1f55-4eb5-b378-ec5c4f19c1c7', 'Emily', 'emily@example.com', '(555) 555-5555','654 Maple St', 'Towntown', 'WA', '54321', 'USA', 75.00, 80, 'Suspended', 90.00, 'USD'),
    ('d1cf484f-3462-4566-bbc5-41501a54be3c', 'Frank', 'frank@example.com', '(555) 555-5555','987 Cedar St', 'Midtown', 'IL', '13579', 'USA', 250.00, 180, 'Active', 200.00, 'USD'),
    ('a4b69d4c-d70f-4b18-b2da-8f63aa93a992', 'Grace', 'grace@example.com', '(555) 555-5555','159 Spruce St', 'Downtown', 'MA', '97531', 'USA', 175.00, 130, 'Active', 160.00, 'USD'),
    ('9fe7d930-1dd6-495b-9f2f-19cf986e8795', 'Henry', 'henry@example.com', '(555) 555-5555','753 Birch St', 'Uptown', 'GA', '35791', 'USA', 280.00, 190, 'Closed', 240.00, 'USD'),
    ('0a3bcad9-3cc3-45d5-a9f7-2ee1a3de6c84', 'Ivy', 'ivy@example.com', '(555) 555-5555','369 Walnut St', 'Westtown', 'OH', '86420', 'USA', 225.00, 150, 'Active', 190.00, 'USD'),
    ('5e1b8aaf-1d8c-457f-801a-8017b0db12a4', 'Jack', 'jack@example.com', '(555) 555-5555','852 Hickory St', 'Easttown', 'PA', '64209', 'USA', 320.00, 220, 'Active', 260.00, 'USD');


INSERT INTO products (product_id, name, description, pallet_id, manufacturer, day, month, year, product_availability, value, currency, category_name, category_description, url, alt_text)
VALUES
    ('c7d8c8ac-51fb-464a-9cac-20265a20f247', 'Purel', 'The best product when it comes to washing your hands!', 1, 'PurelCo', 23, 04, 2024, 'Available', 10.54, 'USD', 'Health','All our health products', 'http:imageLink.com','An IMAGE OF PUREL'),
    ('f6e124d7-7688-4f76-bbe6-8f8fc60edf92', 'VitaBoost', 'Boost your vitality with VitaBoost!', 2, 'VitaHealth', 12, 03, 2024, 'Available', 15.99, 'USD', 'Health','All our health products', 'http:imageLink.com','An IMAGE OF VitaBoost'),
    ('9e65d27e-22df-4043-af96-c7e93d1a16fd', 'GlowGarden', 'Illuminate your garden with GlowGarden lights.', 3, 'Lumina', 05, 05, 2024, 'Available', 29.99, 'USD', 'Home & Garden','Gardening and outdoor products', 'http:imageLink.com','An IMAGE OF GlowGarden'),
    ('a8fb2560-768e-476a-ae49-0a799cb097f7', 'TechWiz', 'Stay ahead with the latest TechWiz gadgets.', 4, 'WizCo', 18, 06, 2024, 'Available', 99.99, 'USD', 'Electronics','Cutting-edge electronics', 'http:imageLink.com','An IMAGE OF TechWiz'),
    ('15d1e46c-8603-4434-8e88-74751e2ab405', 'SnuggleSoft', 'Wrap yourself in comfort with SnuggleSoft blankets.', 5, 'CozyComfort', 21, 07, 2024, 'Available', 49.99, 'USD', 'Home & Garden','Cozy home essentials', 'http:imageLink.com','An IMAGE OF SnuggleSoft'),
    ('2b2594a0-9387-4f8d-af96-0911835f224d', 'FitFuel', 'Fuel your fitness journey with FitFuel supplements.', 6, 'FitLife', 14, 08, 2024, 'Available', 19.99, 'USD', 'Health','All our health products', 'http:imageLink.com','An IMAGE OF FitFuel'),
    ('63ef2de4-6d23-4ac1-b512-8cccf4e6c8e1', 'SmartSweep', 'Keep your floors clean effortlessly with SmartSweep robot vacuum.', 7, 'RoboTech', 27, 09, 2024, 'Available', 199.99, 'USD', 'Home & Garden','Cleaning tools and appliances', 'http:imageLink.com','An IMAGE OF SmartSweep'),
    ('e6f2cd7d-f33a-4183-97b5-750443ae7921', 'ChillZone', 'Create a relaxing atmosphere with ChillZone aroma diffuser.', 8, 'AromaWorks', 30, 10, 2024, 'Available', 39.99, 'USD', 'Home & Garden','Relaxation and aromatherapy', 'http:imageLink.com','An IMAGE OF ChillZone'),
    ('8bdcda82-9568-4682-ba3c-139312b9bbd9', 'BioFresh', 'Revitalize your skin with BioFresh skincare products.', 9, 'NatureCare', 02, 11, 2024, 'Available', 24.99, 'USD', 'Beauty','Skin care essentials', 'http:imageLink.com','An IMAGE OF BioFresh'),
    ('3a693742-5a85-4d28-8a9b-876cf7a05e5e', 'SootheScent', 'Experience the calming power of SootheScent essential oils.', 10, 'AromaWorks', 15, 12, 2024, 'Available', 29.99, 'USD', 'Health','All our health products', 'http:imageLink.com','An IMAGE OF SootheScent'),
    ('bb6eb3f2-65d1-42e4-a4a9-cdcf7c71c9e5', 'EcoFresh', 'Go green with EcoFresh eco-friendly cleaning supplies.', 11, 'EcoLiving', 28, 01, 2025, 'Available', 19.99, 'USD', 'Home & Garden','Eco-friendly home solutions', 'http:imageLink.com','An IMAGE OF EcoFresh');


