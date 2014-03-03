package com.diudiustudio.connection.parser;

interface Parser<Raw, Bean> {
	Bean parse(Raw raw);
}
