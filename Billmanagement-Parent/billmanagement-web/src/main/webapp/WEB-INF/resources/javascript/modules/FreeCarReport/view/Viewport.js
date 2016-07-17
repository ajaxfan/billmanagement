Ext.define('FreeCarReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'FreeCarReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
