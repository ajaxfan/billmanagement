Ext.define('BillUseDetailModule.model.BillUseDetailModel', {
	extend: 'Ext.data.Model',
	
	fields: [
         'dateRange', 'employeeNo', 'remark', 'useBegin', 
         'useEnd', 'useCount', 'sellBegin', 'sellEnd', 
         'sellCount', 'invalidBegin', 'invalidEnd', 'invalidCount'
         , 'subtotalBegin', 'subtotalEnd', 'subtotalCount', 'balanceBegin'
         , 'balanceEnd', 'balanceCount'
    ]
});