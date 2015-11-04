INSERT INTO bike_record(id, manufacturer, model, price, available, purchaseDate, classification, size)
VALUES(109, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(110, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(111, 'Apollo', 'X781','28',  true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(112, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(113, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(114, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(115, 'Apollo', 'X781','28', false, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(116, 'Apollo', 'X781','28', false, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(117, 'Apollo', 'X781','28', false, CURRENT_DATE(),'ROAD','STANDARD_MALE');

INSERT INTO stock(id, partName, numberOfStock)
VALUES(1, 'Wheels', 100),
(2, 'Frame', 100),
(3, 'Brakes', 100),
(4, 'Handlebars', 100);


INSERT INTO maintenance_record(id, actionDate, actionTaken, faultDate, FaultDetails, bike_id) 
VALUES (890, sysDate(), 'fixed', sysDate(), 'wonky wheel', 109),
(891, sysDate(), 'fixed', sysDate(), 'wonky wheel', 109),
(892, sysDate(), 'fixed', sysDate(), 'wonky wheel', 109),
(893, sysDate(), 'fixed', sysDate(), 'wonky wheel', 110),
(894, sysDate(), 'fixed', sysDate(), 'wonky wheel', 110);

INSERT INTO customer(id, firstName, lastName, phoneNo, addressLine1, addressLine2, postcode)
VALUES(300, 'Gareth', 'Barry', '01234567890', '1 Welbeck Avenue', 'Urmston', 'M415AP'),
(301, 'Jordan', 'Henderson', '01234567890', '12 Welbeck Avenue', 'Urmston', 'M415AQ');


INSERT INTO rental_record(id, amountPaid, rentDate, timeBackActual, timeBackDue, timeOut, customer_id, bike_id)
VALUES(400, 3.5, sysDate(), sysDate(), sysDate(), sysDate(), 300, 110),
(401, 3.5, sysDate(), sysDate(), sysDate(), sysDate(), 300, 110),
(402, 3.5, sysDate(), sysDate(), sysDate(), sysDate(), 301, 111);

