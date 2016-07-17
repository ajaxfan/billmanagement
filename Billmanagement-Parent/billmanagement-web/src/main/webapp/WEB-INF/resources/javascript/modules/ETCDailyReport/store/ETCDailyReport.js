Ext.define('ETCDailyReportModule.store.ETCDailyReport', {
    extend: 'Ext.data.Store',
    model: 'ETCDailyReportModule.model.ETCDailyReportModel',
    
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