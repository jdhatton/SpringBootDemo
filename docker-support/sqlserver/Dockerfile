FROM mcr.microsoft.com/mssql/server:2017-latest

ADD data /usr/local/data
ADD entrypoint.sh /

ENTRYPOINT [ "/bin/bash", "entrypoint.sh" ]
CMD [ "/opt/mssql/bin/sqlservr" ]