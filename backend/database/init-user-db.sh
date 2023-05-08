#!/bin/bash
echo "running data script"
psql -U POSTGRES_USER -d $POSTGRES_DB -f "./schema.sql"
psql -U POSTGRES_USER -d $POSTGRES_DB -f "./initial_data.sql"
