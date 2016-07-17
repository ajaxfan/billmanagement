Ext.define('ETCYearReportModule.model.ETCYearReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'recordNo', 'enteName', 'exitName', 'vEnte', 
         'vExit', 'exitDate', 'enteDate', 'totalFare', 
         'carExitcodeRecognize', 'tollType', 'solidFree',
         'receivable', 'exemption'
    ]
});