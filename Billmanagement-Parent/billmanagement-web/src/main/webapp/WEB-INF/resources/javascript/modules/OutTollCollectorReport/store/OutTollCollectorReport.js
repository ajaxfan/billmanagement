Ext.define('OutTollCollectorReportModule.store.OutTollCollectorReport', {
    extend: 'Ext.data.Store',
    model: 'OutTollCollectorReportModule.model.OutTollCollectorReportModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'services/freeTimeList',//请求
        reader: {
            type: 'json',
            root: 'items',
            idProperty: 'recordNo',
            totalProperty: 'totalCount'
        }
    }
});