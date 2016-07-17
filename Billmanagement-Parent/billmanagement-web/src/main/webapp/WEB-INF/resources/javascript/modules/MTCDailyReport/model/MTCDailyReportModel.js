Ext.define('MTCDailyReportModule.model.MTCDailyReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'employeeNo', 'employeeName', 'jilinFare', 'neimengFare', 
         'receivedFare', 'shortFare', 'longFare', 'arrears', 
         'typeOne', 'typeTwo', 'typeThree', 'typeFour',
         'typeFive', 'cash', 'receivableFare'
    ]
});