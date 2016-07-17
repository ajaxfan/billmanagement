Ext.define('ETCDailyReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'ETCDailyReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
