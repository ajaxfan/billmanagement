Ext.define('BillUseDetailModule.store.BillUseDetail', {
    extend: 'Ext.data.Store',
    model: 'BillUseDetailModule.model.BillUseDetailModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'services/billUseDetailList',//请求
        reader: {
            type: 'json',
            root: 'items',
            idProperty: 'employeeNo',
            totalProperty: 'totalCount'
        }
    }
});