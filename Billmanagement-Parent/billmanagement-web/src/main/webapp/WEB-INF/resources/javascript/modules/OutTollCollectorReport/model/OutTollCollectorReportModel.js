Ext.define('OutTollCollectorReportModule.model.OutTollCollectorReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'recordNo', 'enteName', 'exitName', 'vEnte', 
         'vExit', 'exitDate', 'enteDate', 'totalFare', 
         'carExitcodeRecognize', 'tollType', 'solidFree',
         'receivable', 'exemption'
    ]
});