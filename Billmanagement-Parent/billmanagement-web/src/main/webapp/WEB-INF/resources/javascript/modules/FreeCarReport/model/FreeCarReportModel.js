Ext.define('FreeCarReportModule.model.FreeCarReportModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'carOutCount', 'carOutFare', 'ectOutCount', 'ectOutFare', 
         'truckOutCount', 'truckOutFare', 'greenOutCount', 'greenOutFare', 
         'passOutCount', 'passOutFare', 'carInCount', 'truckInCount',
         'carInFare', 'ectInCount', 'greenInCount', 'passInCount'
    ]
});