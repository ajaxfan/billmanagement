Ext.define('ETCYearReportModule.store.ETCYearReport', {
    extend: 'Ext.data.Store',
    model: 'ETCYearReportModule.model.ETCYearReportModel',
    
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