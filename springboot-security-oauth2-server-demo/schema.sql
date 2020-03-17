Drop table if exists oauth_client_details;
create table oauth_client_details (
client_id VARCHAR(255) PRIMARY KEY,
resource_ids VARCHAR(255),
client_secret VARCHAR(255),
scope VARCHAR(255),
authorized_grant_types VARCHAR(255),
web_server_redirect_uri VARCHAR(255),
authorities VARCHAR(255),
access_token_validity INTEGER,
refresh_token_validity INTEGER,
additional_information TEXT,
autoapprove VARCHAR (255) default 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Drop table if exists oauth_access_token;
create table oauth_access_token (
token_id VARCHAR(255),
token BLOB,
authentication_id VARCHAR(255),
user_name VARCHAR(255),
client_id VARCHAR(255),
authentication BLOB,
refresh_token VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
token_id VARCHAR(255),
token BLOB,
authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Drop table if exists oauth_code;
create table oauth_code (
code VARCHAR(255),
authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Drop table if exists oauth_approvals;
create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- customized oauth_client_details table
Drop table if exists ClientDetails;
create table ClientDetails (
  appId VARCHAR(256) PRIMARY KEY,
  resourceIds VARCHAR(256),
  appSecret VARCHAR(256),
  scope VARCHAR(256),
  grantTypes VARCHAR(256),
  redirectUrl VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(256)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Add indexes
create index token_id_index on oauth_access_token (token_id);
create index authentication_id_index on oauth_access_token (authentication_id);
create index user_name_index on oauth_access_token (user_name);
create index client_id_index on oauth_access_token (client_id);
create index refresh_token_index on oauth_access_token (refresh_token);
create index token_id_index on oauth_refresh_token (token_id);
create index code_index on oauth_code (code);