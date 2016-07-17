Ext.define('MTCDailyReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'MTCDailyReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
