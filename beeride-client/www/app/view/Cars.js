Ext.define('Beeride.view.Cars', {
	extend : 'Ext.Panel',
	xtype : 'cars',
	config : {
		layout : 'vbox',
		items : [ {
			xtype : 'list',
			itemTpl : '{name}',
			flex : 1,
			store : 'Cars',
			plugins : [ {
				xclass : 'Ext.plugin.ListPaging',
				autoPaging : true
			} ]
		} ]
	}
});