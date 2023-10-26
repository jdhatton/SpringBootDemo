#!/bin/bash
set -e
if [ "$1" = '/opt/mssql/bin/sqlservr' ]; then
  # If this is the container's first run, initialize the application database
  if [ ! -f /tmp/app-initialized ]; then
    # Initialize the application database asynchronously in a background process. This allows a) the SQL Server process to be the main process in the container, which allows graceful shutdown and other goodies, and b) us to only start the SQL Server process once, as opposed to starting, stopping, then starting it again.
    function initialize_app_database() {
      # Wait a bit for SQL Server to start. SQL Server's process doesn't provide a clever way to check if it's up or not, and it needs to be up before we can import the application database
      echo 'waiting 15s'
      sleep 15s
      #run the setup script to create the DB and the schema in the DB
      echo 'running setup-dbs.sql'
      /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P P@ssword! -d master -i /usr/local/data/setup-dbs.sql
      echo 'running setup-schemas.sql'
      /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P P@ssword! -d master -i /usr/local/data/setup-schemas.sql
      echo 'running setup-tables.sql'
      /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P P@ssword! -d master -i /usr/local/data/setup-tables.sql
      # Note that the container has been initialized so future starts won't wipe changes to the data
      touch /tmp/app-initialized

      echo "setup done"
    }
    initialize_app_database &
  fi
fi
exec "$@"
