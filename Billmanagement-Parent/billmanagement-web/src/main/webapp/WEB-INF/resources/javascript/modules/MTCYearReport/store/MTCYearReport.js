Ext.define('MTCYearReportModule.store.MTCYearReport', {
    extend: 'Ext.data.Store',
    model: 'MTCYearReportModule.model.MTCYearReportModel',
    
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