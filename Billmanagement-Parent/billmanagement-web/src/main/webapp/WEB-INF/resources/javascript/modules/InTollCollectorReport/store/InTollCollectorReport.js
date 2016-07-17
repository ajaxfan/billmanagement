Ext.define('InTollCollectorReportModule.store.InTollCollectorReport', {
    extend: 'Ext.data.Store',
    model: 'InTollCollectorReportModule.model.InTollCollectorReportModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'services/inCollectorDataList',//请求
        reader: {
            type: 'json',
            root: 'items',
            idProperty: 'billNo',
            totalProperty: 'totalCount'
        }
    }
});