Ext.define('MTCMonthReportModule.store.MTCMonthReport', {
    extend: 'Ext.data.Store',
    model: 'MTCMonthReportModule.model.MTCMonthReportModel',
    
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