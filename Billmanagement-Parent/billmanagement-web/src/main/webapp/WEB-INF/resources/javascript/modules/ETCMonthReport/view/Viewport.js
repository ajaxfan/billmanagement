Ext.define('ETCMonthReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'ETCMonthReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
