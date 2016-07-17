Ext.define('OutTollCollectorReportModule.model.OutTollCollectorReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'billName', 'billNo', 'receivableCard', 'receiveCard', 
         'passCar', 'noCard', 'arrears', 'totalFare', 
         'receivableInvalid', 'receiveInvalid', 'invalidCard',
         'militaryVehicle', 'freeCar', 'ucrossCar', 'manageCar', 
         'harvester', 'urgentCar', 'billCount'
    ]
});