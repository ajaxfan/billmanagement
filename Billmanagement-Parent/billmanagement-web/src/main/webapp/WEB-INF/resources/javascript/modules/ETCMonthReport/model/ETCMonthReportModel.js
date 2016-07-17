Ext.define('ETCMonthReportModule.model.ETCMonthReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
	         'employeeNo', 'employeeName', 'receivableFare', 'receiveFare', 
	         'typeOne', 'typeTwo', 'typeThree', 'typeFour', 
	         'typeFive', 'totalCarCount'
    ]
});