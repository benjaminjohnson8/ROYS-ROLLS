INSERT INTO bike_record(id, manufacturer, model, price, available, purchaseDate, classification, size)
VALUES(109, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(110, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(111, 'Apollo', 'X781','28',  true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(112, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(113, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(114, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(115, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(116, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE'),
(117, 'Apollo', 'X781','28', true, CURRENT_DATE(),'ROAD','STANDARD_MALE');

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