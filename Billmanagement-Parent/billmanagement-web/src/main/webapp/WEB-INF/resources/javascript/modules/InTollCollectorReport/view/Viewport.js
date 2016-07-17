Ext.define('InTollCollectorReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'InTollCollectorReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
