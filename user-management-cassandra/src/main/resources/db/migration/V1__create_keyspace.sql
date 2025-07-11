CREATE KEYSPACE IF NOT EXISTS migeri WITH REPLICATION =
{ 'class' : 'SimpleStrategy',
'replication_factor' : '1'
};