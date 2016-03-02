Ext.define('Beeride.model.Carpool', {
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