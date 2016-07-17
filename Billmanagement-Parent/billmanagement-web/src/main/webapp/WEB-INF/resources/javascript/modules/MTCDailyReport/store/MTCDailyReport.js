Ext.define('MTCDailyReportModule.store.MTCDailyReport', {
    extend: 'Ext.data.Store',
    model: 'MTCDailyReportModule.model.MTCDailyReportModel',
    
    autoLoad: false,
    autoDestroy: true,
    proxy: {
        type : 'ajax',
        actionMethods: { read: 'POST' },
        url : 'services/mtcDailyDataList',//请求
        reader: {
            type: 'json',
            root: 'items',
            idProperty: 'employeeNo',
            totalProperty: 'totalCount'
        }
    }
});