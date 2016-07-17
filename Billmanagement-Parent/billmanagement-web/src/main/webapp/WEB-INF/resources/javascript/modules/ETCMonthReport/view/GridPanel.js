Ext.define('ETCMonthReportModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
	requires: [
       "Ext.plugins.QueryCriteriaToolbar"
	],
    defaults:{ sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '员工编号',
        width: 160,
        dataIndex: 'employeeNo'
    }, {
        header: '员工名',
        width: 140,
        dataIndex: 'employeeName'
    }, {
        header: '应收金额',
        width: 160,
        dataIndex: 'receivableFare'
    }, {
        header: '实收金额',
        width: 140,
        dataIndex: 'receiveFare'
    }, {
        header: '1型',
        width: 80,
        dataIndex: 'typeOne'
    }, {
        header: '2型',
        width: 80,
        dataIndex: 'typeTwo'
    }, {
        header: '3型',
        width: 80,
        dataIndex: 'typeThree'
    }, {
        header: '4型',
        width: 80,
        dataIndex: 'typeFour'
    }, {
        header: '5型',
        width: 80,
        dataIndex: 'typeFive'
    }, {
        header: '总车流量',
        width: 90,
        dataIndex: 'totalCarCount'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('ETCMonthReportModule.store.ETCMonthReport');
    	
    	// Copy properties to Origin Object
    	Ext.apply(this, {
    		store: store,
    		tbar: {// Top bar
    			xtype: 'querycriteriatoolbar',
            	store: store, 
            	label: '车牌号', 
            	paramName: 'carCode',
            	hideAxisum: true
    		}
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});