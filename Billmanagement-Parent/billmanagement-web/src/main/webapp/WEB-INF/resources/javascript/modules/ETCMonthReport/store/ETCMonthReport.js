Ext.define('ETCMonthReportModule.store.ETCMonthReport', {
    extend: 'Ext.data.Store',
    model: 'ETCMonthReportModule.model.ETCMonthReportModel',
    
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