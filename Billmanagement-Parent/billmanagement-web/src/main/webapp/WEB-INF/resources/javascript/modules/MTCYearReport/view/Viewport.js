Ext.define('MTCYearReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'MTCYearReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
