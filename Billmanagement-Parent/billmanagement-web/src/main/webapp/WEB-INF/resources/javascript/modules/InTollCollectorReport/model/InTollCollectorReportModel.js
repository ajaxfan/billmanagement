Ext.define('InTollCollectorReportModule.model.InTollCollectorReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'recordNo', 'enteName', 'exitName', 'vEnte', 
         'vExit', 'exitDate', 'enteDate', 'totalFare', 
         'carExitcodeRecognize', 'tollType', 'solidFree',
         'receivable', 'exemption'
    ]
});