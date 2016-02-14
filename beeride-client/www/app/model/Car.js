Ext.define('Beeride.model.Car', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'id',
			type : 'long'
		}, {
			name : 'name',
			type : 'string'
		} ]
	}
});