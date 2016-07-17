Ext.define('MTCMonthReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'MTCMonthReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
