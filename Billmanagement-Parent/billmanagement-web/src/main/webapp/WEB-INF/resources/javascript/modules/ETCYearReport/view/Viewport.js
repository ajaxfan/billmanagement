Ext.define('ETCYearReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'ETCYearReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
