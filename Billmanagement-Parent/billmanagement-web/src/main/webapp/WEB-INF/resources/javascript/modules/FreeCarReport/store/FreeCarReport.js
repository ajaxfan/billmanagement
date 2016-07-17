Ext.define('FreeCarReportModule.store.FreeCarReport', {
    extend: 'Ext.data.Store',
    model: 'FreeCarReportModule.model.FreeCarReportModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'services/freeCarList',//请求
        reader: {
            type: 'json',
            root: 'items',
            idProperty: 'carOutCount',
            totalProperty: 'totalCount'
        }
    }
});