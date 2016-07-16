/**
 * 查看图片列
 */
Ext.define('Ext.plugins.PicColumn', {
	extend: 'Ext.grid.column.Column',
	alias: 'widget.piccolumn',
	
	requires: ["Ext.plugins.ImageWindow"],
	
	initComponent: function() {
		Ext.apply(this, {
			header: '图片',
			width: 50,
			align: 'center',
			renderer: function (data, metadata, record, rowIndex, columnIndex, store) {  
			     return '<img src="images/pic.png" width="60%" height="60%"></img>'; 
			},
			listeners: {
				click: function(){
					var record = arguments[5];
					// 图片所在的路径
					var url = "http://localhost:8080/ImageEngine/cdn/" + record.get("recordNo");
					
					// 判断窗体对象是否存在, 如果不存在，就创建一个新的窗体对象
	            	var imageWindow = Ext.create('Ext.plugins.ImageWindow', {
	            		items: {
        			    	html: '<img width="100%" height="100%" src="' + url + '" onerror="javascript:this.src=\'images/nopicture.gif\';" alt="pic"></img>'
        			    }
	            	});
	            	
	            	imageWindow.show(); // 显示窗体
	            	imageWindow.center();// 窗体居中显示
				}
			}
		});
        this.callParent(arguments);
	}
})