Ext.define('BillUseDetailModule.view.GridPanel', {
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
        header: '员工号',
        width: 160,
        dataIndex: 'employeeNo'
    }, {
        header: '员工姓名',
        width: 140,
        dataIndex: 'employeeName'
    }, {
        header: '站名称',
        width: 160,
        dataIndex: 'enteName'
    }, {
        header: '票号',
        width: 140,
        dataIndex: 'orderNo'
    }, {
        header: '发票日期',
        width: 80,
        dataIndex: 'orderDate'
    }, {
        header: '总费额',
        width: 80,
        dataIndex: 'totalFare'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('BillUseDetailModule.store.BillUseDetail');
    	
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