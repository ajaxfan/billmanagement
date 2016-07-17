Ext.define('ETCDailyReportModule.model.ETCDailyReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'employeeNo', 'employeeName', 'receivableFare', 'receiveFare', 
         'typeOne', 'typeTwo', 'typeThree', 'typeFour', 
         'typeFive', 'totalCarCount'
    ]
});